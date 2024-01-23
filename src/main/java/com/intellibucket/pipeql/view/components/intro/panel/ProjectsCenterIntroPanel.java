package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleOkGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.list.GPanelList;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.ButtonGPanel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.panel.TransparentGPanel;
import com.intellibucket.pipeql.lib.seperator.GSeparator;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.CustomTextField;
import com.intellibucket.pipeql.view.client.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.models.ProjectItemModel;
import com.intellibucket.pipeql.view.util.BordersUtil;
import com.intellibucket.pipeql.view.util.ColorUtils;
import com.intellibucket.pipeql.view.util.FontsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProjectsCenterIntroPanel extends ChangeablePanel {

    private List<ProjectItemModel> projectModels;

    private final AbstractGPanel headerProjectsCenterIntroPanel;
    private AbstractGPanel bodyProjectsCenterIntroPanel;

    {
        this.setLayout(new BorderLayout());
    }

    public ProjectsCenterIntroPanel(List<ProjectItemModel> projectModels) {
        super();
        this.projectModels = projectModels;
        this.headerProjectsCenterIntroPanel = new HeaderProjectsCenterIntroPanel();
        this.bodyProjectsCenterIntroPanel = new TransportBodyProjectsCenterIntroPanel(projectModels);
    }

    public List<ProjectItemModel> getProjectModels() {
        return projectModels;
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                headerProjectsCenterIntroPanel,
                bodyProjectsCenterIntroPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(headerProjectsCenterIntroPanel, BorderLayout.NORTH);
        this.add(bodyProjectsCenterIntroPanel, BorderLayout.CENTER);
    }

    class HeaderProjectsCenterIntroPanel extends AbstractGPanel{

        private final AbstractGPanel leftHeaderProjectsCenterIntroPanel = new LeftHeaderProjectsCenterIntroPanel();
        private final AbstractGPanel rightHeaderProjectsCenterIntroPanel = new RightHeaderProjectsCenterIntroPanel();

        private final GSeparator seperator = new GSeparator();

        {
            this.setLayout(new BorderLayout());
            this.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    leftHeaderProjectsCenterIntroPanel,
                    rightHeaderProjectsCenterIntroPanel,
                    seperator
            );
        }

        @Override
        public void addComponents() {
            this.add(leftHeaderProjectsCenterIntroPanel, BorderLayout.WEST);
            this.add(rightHeaderProjectsCenterIntroPanel, BorderLayout.EAST);
            this.add(seperator, BorderLayout.SOUTH);
        }

        @Override
        public void setActions() {

        }


        class LeftHeaderProjectsCenterIntroPanel extends AbstractGPanel{

            private final AbstractGTextField textField = new CustomTextField(ImageToolKit.getIcon("search@20x20"),40);
            {
                this.textField.getDocument().addDocumentListener(new DocumentListener() {
                    private void update(DocumentEvent event){
                        log.info("Clicked on search button with text: {}",textField.getText());
                        String text = textField.getText();
                        List<ProjectItemModel> filteredProjectModels = projectModels;
                        if (!StringUtils.isBlank(text)) {
                            filteredProjectModels = projectModels.stream()
                                    .filter(projectItemModel -> StringUtils.containsIgnoreCase(projectItemModel.getProjectName(),text))
                                    .collect(Collectors.toList());
                        }
                        ProjectsCenterIntroPanel.this.remove(bodyProjectsCenterIntroPanel);
                        bodyProjectsCenterIntroPanel = new TransportBodyProjectsCenterIntroPanel(filteredProjectModels);
                        bodyProjectsCenterIntroPanel.initialize();
                        ProjectsCenterIntroPanel.this.add(bodyProjectsCenterIntroPanel, BorderLayout.CENTER);
                        ProjectsCenterIntroPanel.this.refresh();
                        SwingUtilities.invokeLater(textField::requestFocusInWindow);
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        update(e);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        update(e);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        update(e);
                    }
                });
            }

            @Override
            public List<ComponentInitializer> getComponentInitializers() {
                return List.of(
                        textField
                );
            }

            @Override
            public void addComponents() {
                this.add(textField);
            }
        }

    }
}

class RightHeaderProjectsCenterIntroPanel extends AbstractGPanel{
    private IntroductionPanelClient introductionPanelClient = new IntroductionPanelClient();

    private AbstractGButton newButton = new SimpleOkGButton("New");
    private AbstractGButton openButton = new SimpleGButton("Open");
    private AbstractGButton vcsButton = new SimpleGButton("Get VCS");


    {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                newButton,
                openButton,
                vcsButton
        );
    }

    @Override
    public void addComponents() {
        this.add(newButton);
        this.add(openButton);
        this.add(vcsButton);
    }

    @Override
    public void setActions(){
        this.newButton.addActionListener(e -> this.introductionPanelClient.newProject(this));
        this.openButton.addActionListener(e -> this.introductionPanelClient.openProject(this));
    }
}
class TransportBodyProjectsCenterIntroPanel extends AbstractGPanel{

    private BodyProjectsCenterIntroPanel bodyProjectsCenterIntroPanel;

    {
        this.setLayout(new BorderLayout());
    }

    public TransportBodyProjectsCenterIntroPanel(List<ProjectItemModel> projectItemModels) {
        bodyProjectsCenterIntroPanel = new BodyProjectsCenterIntroPanel(projectItemModels);
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                bodyProjectsCenterIntroPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(bodyProjectsCenterIntroPanel, BorderLayout.CENTER);
    }
}
class BodyProjectsCenterIntroPanel extends AbstractGPanel{

    private GPanelList bodyProjectsCenterIntroPanel;
    private JScrollPane scrollPane;

    {
        this.setLayout(new BorderLayout());
        this.setBorder(BordersUtil.EMPTY_BORDER_5_10_10_5);
    }

    public BodyProjectsCenterIntroPanel(List<ProjectItemModel> projectItemModels) {
        var projectItems = projectItemModels.
                stream()
                .map(ProjectItem::new)
                .map(item->(ComponentInitializer)item)
                .toList();
        bodyProjectsCenterIntroPanel = new GPanelList(projectItems);
        scrollPane = new JScrollPane(bodyProjectsCenterIntroPanel);
        scrollPane.setBorder(BordersUtil.EMPTY_BORDER_5_10_10_5);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                bodyProjectsCenterIntroPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(scrollPane, BorderLayout.CENTER);
    }
}


class ProjectItem extends AbstractGPanel {
    private final AbstractGPanel picProjectItem;
    private final AbstractGPanel infoProjectItem;
    private final AbstractGPanel settingsButton;

    {
        this.setLayout(new BorderLayout());
        this.setBorder(BordersUtil.EMPTY_BORDER_5_10_5_10);
    }

    public ProjectItem(ProjectItemModel model) {
        picProjectItem = new PicProjectItem(model);
        infoProjectItem = new InfoProjectItem(model.getProjectName(),model.getProjectPath());
        settingsButton = new SettingsButtonOfProjectItem();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                picProjectItem,
                infoProjectItem,
                settingsButton
        );
    }

    @Override
    public void addComponents() {
        this.add(picProjectItem, BorderLayout.WEST);
        this.add(infoProjectItem, BorderLayout.CENTER);
        this.add(settingsButton, BorderLayout.EAST);
    }

    class SettingsButtonOfProjectItem extends AbstractGPanel{

        private final AbstractGButton settingsButton;

        {
            this.setLayout(new GridBagLayout());
        }

        public SettingsButtonOfProjectItem() {
            this.settingsButton = new SimpleIconGButton("inlaySettings");
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    settingsButton
            );
        }

        @Override
        public void addComponents() {
            this.add(settingsButton);
        }
    }

    class PicProjectItem extends TransparentGPanel {
        private final Color color;
        private final AbstractGLabel label;
        public PicProjectItem(ProjectItemModel model) {
            this.setPreferredSize(new Dimension(40, 25));
            this.label = new SimpleGLabel(model.getProjectName().substring(0, 1), FontsUtil.HELVETICA_PLAIN_20);
            this.label.setBackground(ColorUtils.TRANSPARENT);
            this.setLayout(new GridBagLayout());
            this.label.setBorder(BordersUtil.EMPTY_BORDER);
            this.color = model.getColor();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(this.color);
            g2d.fill(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 20, 20));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    label
            );
        }

        @Override
        public void addComponents() {
            this.add(label);
        }
    }

    class InfoProjectItem extends ButtonGPanel{
        private final AbstractGLabel projectName;
        private final AbstractGLabel projectPath;

        {
            this.setLayout(new GridLayout(2, 1));
            this.setBorder(BordersUtil.EMPTY_BORDER_0_10_0_0);
        }

        public InfoProjectItem(String projectName,String projectPath) {
            this.projectName = new SimpleGLabel(projectName, FontsUtil.HELVETICA_BOLD_16);
            this.projectPath = new SimpleGLabel(projectPath, FontsUtil.HELVETICA_PLAIN_12);
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    projectName,
                    projectPath
            );
        }

        @Override
        public void addComponents() {
            this.add(projectName);
            this.add(projectPath);
        }

        @Override
        public void postInitialize() {
            this.projectName.setForeground(ColorUtils.TEXT_COLOR);
            this.projectPath.setForeground(ColorUtils.GREY_TEXT_COLOR);
            this.projectName.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.projectPath.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
    }


}