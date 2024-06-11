package binaris.mystic_grove.render;

import binaris.mystic_grove.MysticGroveMod;
import binaris.mystic_grove.entities.MysticDeer;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;

public class MysticDeerModel extends EntityModel<MysticDeer> {
    public static final EntityModelLayer MODEL_DEER = new EntityModelLayer(MysticGroveMod.id("mystic_deer"), "main");
    private final ModelPart body;
    private final ModelPart bb_main;

    public MysticDeerModel(ModelPart root) {
        this.body = root.getChild("body");
        this.bb_main = root.getChild("bb_main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 33).cuboid(-6.0F, -9.0F, 7.0F, 2.0F, 9.0F, 2.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 21).cuboid(-3.0F, -26.0F, -9.0F, 4.0F, 4.0F, 8.0F).uv(0, 0).cuboid(-3.0F, -15.0F, -6.0F, 4.0F, 4.0F, 8.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -23.0F, -3.0F, 4.0F, 8.0F, 3.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(4, 21).cuboid(4.0F, -29.0F, -8.0F, 1.0F, 6.0F, 1.0F).uv(0, 21).cuboid(-7.0F, -29.0F, -8.0F, 1.0F, 6.0F, 1.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(0, 11).cuboid(1.0F, -24.0F, -7.0F, 4.0F, 1.0F, 1.0F).uv(0, 13).cuboid(-7.0F, -24.0F, -7.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);


    }

    @Override
    public void setAngles(MysticDeer entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.body).forEach((modelRenderer) -> modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha));

        ImmutableList.of(this.bb_main).forEach((modelRenderer) -> modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha));
    }
}
