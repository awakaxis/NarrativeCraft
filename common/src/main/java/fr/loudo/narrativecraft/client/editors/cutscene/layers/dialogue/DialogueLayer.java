package fr.loudo.narrativecraft.client.editors.cutscene.layers.dialogue;

import fr.loudo.narrativecraft.api.editors.cutscene.keyframes.Keyframe;
import fr.loudo.narrativecraft.api.editors.cutscene.layers.CutsceneLayer;
import fr.loudo.narrativecraft.api.editors.cutscene.layers.ICutsceneLayerType;
import fr.loudo.narrativecraft.client.ClientNarrativeCraftMod;
import fr.loudo.narrativecraft.editors.cutscene.keyframes.DialogueKeyframe;

import java.util.HashSet;
import java.util.List;

public class DialogueLayer extends CutsceneLayer {

    private final HashSet<Integer> executed = new HashSet<>();

    public DialogueLayer(ICutsceneLayerType layerType) {
        super(layerType);
    }

    @Override
    public Keyframe createDefaultKeyframe(int tick) {
        return new DialogueKeyframe(this, tick);
    }

    @Override
    public boolean execute(float tick) {
        List<DialogueKeyframe> keyframes = getSortedKeyframes(DialogueKeyframe.class);
        for (DialogueKeyframe keyframe : keyframes) {
            if (keyframe.getTick() == (int) tick && !executed.contains(keyframe.getTick())) {
                ClientNarrativeCraftMod.getInstance().getCutsceneMakerEditor().getPlayback().pause(true);
                ClientNarrativeCraftMod.getInstance().getCutsceneMakerEditor().getControl().pause();
                executed.add(keyframe.getTick());
                return true;
            } else if (tick < keyframe.getTick()) {
                executed.remove(keyframe.getTick());
            }
        }

        return false;
    }
}
