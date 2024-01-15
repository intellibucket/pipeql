package com.intellibucket.pipeql.view.components.main.panel.main.left;

import com.intellibucket.pipeql.lib.tree.AbstractGTree;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class FileTree extends AbstractGTree {
    public FileTree() {
    }

    public FileTree(Object[] value) {
        super(value);
    }

    public FileTree(Vector<?> value) {
        super(value);
    }

    public FileTree(Hashtable<?, ?> value) {
        super(value);
    }

    public FileTree(TreeNode root) {
        super(root);
    }

    public FileTree(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }

    public FileTree(TreeModel newModel) {
        super(newModel);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
