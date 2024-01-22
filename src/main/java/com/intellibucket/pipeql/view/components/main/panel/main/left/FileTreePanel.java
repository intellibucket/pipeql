package com.intellibucket.pipeql.view.components.main.panel.main.left;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.client.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.util.List;
import java.util.Objects;

public class FileTreePanel extends AbstractGSimplePanel {
    private final FileTree fileTree;
    private final DefaultTreeModel treeModel;

    {
        setLayout(new BorderLayout());
        var root = new DefaultMutableTreeNode("Project");

        treeModel = new DefaultTreeModel(root);
        fileTree = new FileTree(treeModel);

        // Set a custom cell renderer to display custom icons
        fileTree.setCellRenderer(new CustomFileTreeCellRenderer());

        var scrollPane = new JScrollPane(fileTree);
        add(scrollPane, BorderLayout.CENTER);
        var projectPath = Objects.requireNonNullElse(IntroductionPanelClient.PROJECT_PATH, AbstractApplicationProfileInitializer.PROFILE.resourcePath().concat("defaultProject"));
        buildFileTree(root, new File(projectPath));
        expandAllNodes(fileTree, 0, fileTree.getRowCount());

        try {
            var watchService = FileSystems.getDefault().newWatchService();
            var path = Paths.get(projectPath);
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            new Thread(() -> {
                try {
                    while (true) {
                        var key = watchService.take();
                        for (WatchEvent<?> ignored : key.pollEvents()) {
                            updateFileTree(root, new File(projectPath));
                        }
                        key.reset();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildFileTree(DefaultMutableTreeNode parentNode, File parentFile) {
        if (parentFile.isDirectory()) {
            var directoryNode = new DefaultMutableTreeNode(parentFile.getName());
            parentNode.add(directoryNode);

            var files = parentFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    buildFileTree(directoryNode, file);
                }
            }
        } else {
            parentNode.add(new DefaultMutableTreeNode(parentFile.getName()));
        }
    }

    private void updateFileTree(DefaultMutableTreeNode parentNode, File parentFile) {
        parentNode.removeAllChildren();
        buildFileTree(parentNode, parentFile);
        treeModel.reload();
        expandAllNodes(fileTree, 0, fileTree.getRowCount());
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }

        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return null;
    }

    @Override
    public void addComponents() {

    }

    private static class CustomFileTreeCellRenderer extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            if (value instanceof DefaultMutableTreeNode) {
                Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
                if (userObject instanceof String) {

                    setIcon(UIManager.getIcon("FileView.directoryIcon"));
                }
            }

            return this;
        }
    }
}
