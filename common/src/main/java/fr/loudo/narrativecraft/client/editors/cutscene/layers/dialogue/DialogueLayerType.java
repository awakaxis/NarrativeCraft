package fr.loudo.narrativecraft.client.editors.cutscene.layers.dialogue;

import com.google.gson.JsonObject;
import fr.loudo.narrativecraft.api.editors.cutscene.keyframes.Keyframe;
import fr.loudo.narrativecraft.api.editors.cutscene.layers.CutsceneLayer;
import fr.loudo.narrativecraft.api.editors.cutscene.layers.ICutsceneLayerType;
import fr.loudo.narrativecraft.editors.cutscene.keyframes.DialogueKeyframe;

public class DialogueLayerType implements ICutsceneLayerType {

    public static final String ID = "dialogue";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "Dialogue";
    }

    @Override
    public CutsceneLayer createLayer() {
        return new DialogueLayer(this);
    }

    @Override
    public JsonObject serializeKeyframe(Keyframe keyframe) {
        if (!(keyframe instanceof DialogueKeyframe dialogueKeyframe)) return null;
        JsonObject json = new JsonObject();
        json.addProperty("tick", dialogueKeyframe.getTick());
        return json;
    }

    @Override
    public Keyframe deserializeKeyframe(CutsceneLayer layer, JsonObject json) {
        if (!json.has("tick")) return null;

        DialogueKeyframe dialogueKeyframe = new DialogueKeyframe(layer, json.get("tick").getAsInt());

        return dialogueKeyframe;
    }
}
