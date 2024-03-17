package mythcore.dungeons.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import mythcore.dungeons.DungeonsRPG;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tab.Tab;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class StatScreen extends Screen {
    private static final Identifier TEXTURE = new Identifier(DungeonsRPG.MOD_ID, "textures/gui/stat_screen.png");
    public StatScreen() {
        super(Text.translatable("screen.dungeonsrpg.stat_screen"));
    }

    private int backgroundWidth = 166;
    private int backgroundHeight = 248;
    private int x;
    private int y;
    private PlayerEntity playerEntity;
    @Override
    protected void init() {
        super.init();
        //example button
    }



    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        drawBackground(context);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }
    protected void drawBackground(DrawContext context) {
        //RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        //RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    protected void drawPlayerHead(DrawContext context){
        this.playerEntity = this.client.player;
    }

    @Override
    public void tick() {
        super.tick();
    }


    public void forEachChild(Consumer<ClickableWidget> consumer) {

    }

    public void refreshGrid(ScreenRect tabArea) {

    }
}
