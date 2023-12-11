package net.ukaye.acoustic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.ukaye.acoustic.entity.SonicArrowEntity;

public class AcousticClient implements ClientModInitializer {

	public static final Identifier TEXTURE = new Identifier("acoustic:textures/entity/projectiles/sonic_arrow.png");
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		EntityRendererRegistry.register(Acoustic.SonicArrowEntityType, (context) -> new ProjectileEntityRenderer<SonicArrowEntity>(context) {
			@Override
			public Identifier getTexture(SonicArrowEntity entity) {
				return TEXTURE;
			}
		});
	}
}