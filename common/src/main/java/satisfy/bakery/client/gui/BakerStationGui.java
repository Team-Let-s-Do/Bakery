package satisfy.bakery.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import de.cristelknight.doapi.client.recipebook.screen.AbstractRecipeBookGUIScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import satisfy.bakery.client.gui.handler.BakerStationGuiHandler;
import satisfy.bakery.client.recipebook.BakerStationRecipeBook;
import satisfy.bakery.util.BakeryIdentifier;

public class BakerStationGui extends AbstractRecipeBookGUIScreen<BakerStationGuiHandler> {

    private static final ResourceLocation BG = new BakeryIdentifier("textures/gui/bakerstation.png");

    public BakerStationGui(BakerStationGuiHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title, new BakerStationRecipeBook(), BG);
    }

    @Override
    protected void init() {
        this.titleLabelX += 2;
        this.titleLabelY += -3;
        super.init();
    }

    protected void renderProgressArrow(GuiGraphics guiGraphics) {
        final int progressX = this.menu.getShakeXProgress();
        guiGraphics.blit(BG, leftPos + 94, topPos + 45, 177, 26, progressX, 10);
        final int progressY = this.menu.getShakeYProgress();
        guiGraphics.blit(BG, leftPos + 96, topPos + 22 + 20 - progressY, 179, 2 + 20 - progressY, 15, progressY);
    }
}

