package binaris.mystic_grove.render;

import binaris.mystic_grove.MysticGroveMod;
import binaris.mystic_grove.entities.MysticDeer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MysticDeerRenderer extends MobEntityRenderer<MysticDeer, MysticDeerModel>{
    public MysticDeerRenderer(EntityRendererFactory.Context context) {
        super(context, new MysticDeerModel(context.getPart(MysticDeerModel.MODEL_DEER)), 0.5f);
    }

    @Override
    public Identifier getTexture(MysticDeer entity) {
        return new Identifier(MysticGroveMod.MODID, "textures/entity/mystic_deer.png");
    }
}
