package com.intellibucket.pipeql.view.components.main.panel.main.left;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.util.List;

public class FileTreePanel extends AbstractGSimplePanel {
    private final FileTree fileTree;

    {

        setLayout(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Project");

        fileTree = new FileTree(root);


        JScrollPane scrollPane = new JScrollPane(fileTree);
        add(scrollPane, BorderLayout.CENTER);


        File projectRoot = new File("C:/Users/Emil/Desktop/project");
        buildFileTree(root, projectRoot);


        expandAllNodes(fileTree, 0, fileTree.getRowCount());
    }

    private void buildFileTree(DefaultMutableTreeNode parentNode, File parentFile) {
        if (parentFile.isDirectory()) {
            DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(parentFile.getName());
            parentNode.add(directoryNode);

            File[] files = parentFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    buildFileTree(directoryNode, file);
                }
            }
        } else {
            parentNode.add(new DefaultMutableTreeNode(parentFile.getName()));
        }
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
}
