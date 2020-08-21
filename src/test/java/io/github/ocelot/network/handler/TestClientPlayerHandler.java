package io.github.ocelot.network.handler;

import io.github.ocelot.client.screen.ValueContainerEditorScreenImpl;
import io.github.ocelot.common.valuecontainer.ValueContainer;
import io.github.ocelot.network.TestMessageHandler;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.PacketDistributor;

public class TestClientPlayerHandler implements ITestClientPlayHandler
{
    private static final ResourceLocation BACKGROUND_LOCATION = new ResourceLocation("examplemod", "textures/gui/value_container_editor.png");

    @Override
    public Screen createValueContainerScreen(ValueContainer container, BlockPos pos)
    {
        return new ValueContainerEditorScreenImpl(container, pos, () -> new StringTextComponent("Test Value Container Editor"))
        {
            @Override
            public ResourceLocation getBackgroundTextureLocation()
            {
                return BACKGROUND_LOCATION;
            }

            @Override
            protected void sendDataToServer()
            {
                TestMessageHandler.PLAY.send(PacketDistributor.SERVER.noArg(), this.createSyncMessage());
            }
        };
    }
}
