package com.intellibucket.pipeql.lib.tree;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.util.Hashtable;
import java.util.Vector;

public abstract class AbstractMaximizedGTree extends AbstractGTree{
    public AbstractMaximizedGTree() {
    }

    public AbstractMaximizedGTree(Object[] value) {
        super(value);
    }

    public AbstractMaximizedGTree(Vector<?> value) {
        super(value);
    }

    public AbstractMaximizedGTree(Hashtable<?, ?> value) {
        super(value);
    }

    public AbstractMaximizedGTree(TreeNode root) {
        super(root);
    }

    public AbstractMaximizedGTree(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }

    public AbstractMaximizedGTree(TreeModel newModel) {
        super(newModel);
    }
}
