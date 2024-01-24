package com.intellibucket.pipeql.lib.tree;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.util.Hashtable;
import java.util.Vector;

public abstract class AbstractGTree   extends JTree implements ComponentInitializer {
    public AbstractGTree() {
    }

    public AbstractGTree(Object[] value) {
        super(value);
    }

    public AbstractGTree(Vector<?> value) {
        super(value);
    }

    public AbstractGTree(Hashtable<?, ?> value) {
        super(value);
    }

    public AbstractGTree(TreeNode root) {
        super(root);
    }

    public AbstractGTree(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }

    public AbstractGTree(TreeModel newModel) {
        super(newModel);
    }
}
