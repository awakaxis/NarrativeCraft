package fr.loudo.narrativecraft.editors.cutscene.keyframes;

import fr.loudo.narrativecraft.api.editors.cutscene.keyframes.Keyframe;
import fr.loudo.narrativecraft.api.editors.cutscene.keyframes.KeyframeMenu;
import fr.loudo.narrativecraft.api.editors.cutscene.layers.CutsceneLayer;
import fr.loudo.narrativecraft.client.editors.cutscene.menu.DialogueKeyframeMenu;

public class DialogueKeyframe extends Keyframe {
    public DialogueKeyframe(CutsceneLayer layer, int tick) {
        super(layer, tick);
    }

    @Override
    public KeyframeMenu<?> createMenu() {
        return new DialogueKeyframeMenu(this);
    }
}
