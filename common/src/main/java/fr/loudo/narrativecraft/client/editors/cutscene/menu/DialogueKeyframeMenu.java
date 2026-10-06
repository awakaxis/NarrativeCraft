package fr.loudo.narrativecraft.client.editors.cutscene.menu;

import fr.loudo.narrativecraft.api.editors.cutscene.keyframes.KeyframeMenu;
import fr.loudo.narrativecraft.editors.cutscene.keyframes.DialogueKeyframe;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;

public class DialogueKeyframeMenu extends KeyframeMenu<DialogueKeyframe> {
    public DialogueKeyframeMenu(DialogueKeyframe keyframe) {
        super(keyframe);
    }

    @Override
    protected int getContentHeight() {
        return 0;
    }

    @Override
    protected void renderContent(GuiGraphics graphics, DeltaTracker delta, int x, int y, int contentWidth, int mouseX, int mouseY) {

    }

    @Override
    protected void applyChanges() {

    }

    @Override
    protected void initContent() {

    }
}
