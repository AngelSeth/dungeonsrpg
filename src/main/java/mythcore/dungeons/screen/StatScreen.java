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
    private static final Identifier STAT_TEXTURE = new Identifier(DungeonsRPG.MOD_ID, "textures/gui/stats.png");
    public StatScreen() {
        super(Text.translatable("screen.dungeonsrpg.stat_screen"));
    }

    private int backgroundWidth = 166;
    private int backgroundHeight = 248;
    private int barWidth = 156;
    private int barHeight = 5;
    private int statHeight = 145;
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
        drawPlayerName(context);
        drawPlayerJob(context);
        drawPlayerTitle(context);
        drawPlayerLevel(context);
        drawPlayerFatigue(context);
        drawPlayerHealth(context);
        drawPlayerMana(context);
        drawPlayerStats(context);
        drawPlayerPoints(context);
        super.render(context, mouseX, mouseY, delta);

    }

    @Override
    public boolean shouldPause() {
        return false;
    }
    //turn on to make background transparent
    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }
    protected void drawBackground(DrawContext context) {
        //RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        //RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        //drawStatusText(context);
    }

    /*protected void drawStatusText(DrawContext context){
        Text statusText = Text.literal("STATUS");

        int yOffset = ((height - backgroundHeight) / 2) + 20;
        int xOffset = ((width - backgroundWidth) / 2) + (backgroundWidth / 2);
        context.drawText(this.textRenderer, statusText, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
    }*/

    protected void drawPlayerName(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            Text playerName = Text.literal("Name: " + playerEntity.getNameForScoreboard());

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 45;
            context.drawText(this.textRenderer, playerName, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
        }
    }



    protected void drawPlayerJob(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //eventually change to a method to get player job
            //also make sure to do an if null, and then have it be "Job: None"
            Text playerJob = Text.literal("Job: ");

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 60;
            context.drawText(this.textRenderer, playerJob, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
        }
    }

    protected void drawPlayerTitle(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //eventually change to a method to get player title
            //also make sure to do an if null, and then have it be "Title: None"
            Text playerTitle = Text.literal("Title: ");

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 75;
            context.drawText(this.textRenderer, playerTitle, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
        }
    }
    protected void drawPlayerHealth(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //eventually change to a method to get player title
            float playerHP = playerEntity.getHealth();
            float playerAbsorption = playerEntity.getAbsorptionAmount();
            float displayedHP = Math.round((playerHP + playerAbsorption) * 10);
            Text playerHealth = Text.literal("HP: " + displayedHP);

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 90;
            context.drawText(this.textRenderer, playerHealth, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            drawPlayerHealthBar(context);
        }
    }
    protected void drawPlayerHealthBar(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            float playerHP = playerEntity.getHealth();
            float maxHealth = playerEntity.getMaxHealth();
            int healthPercentage = (int) ((playerHP / maxHealth) * barWidth);
            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 100;
            context.drawTexture(STAT_TEXTURE, xOffset, yOffset, 0, 0, barWidth, barHeight);
            context.drawTexture(STAT_TEXTURE, xOffset, yOffset, 0, 5, healthPercentage, barHeight);
        }
    }

    protected void drawPlayerMana(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //eventually change to a method to get player mana
            float playerMP = playerEntity.getMaxAir();
            Text playerMana = Text.literal("MP: " + playerMP);
            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 110;
            context.drawText(this.textRenderer, playerMana, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            drawPlayerManaBar(context);
        }
    }
    protected void drawPlayerManaBar(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //eventually change to a method to get player mana and mana percentage
            float playerMP = playerEntity.getAir();
            float maxMana = playerEntity.getMaxAir();
            int manaPercentage = (int) ((playerMP / maxMana) * barWidth);
            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 120;
            if(maxMana != 0)
            {context.drawTexture(STAT_TEXTURE, xOffset, yOffset, 0, 0, barWidth, barHeight);
            context.drawTexture(STAT_TEXTURE, xOffset, yOffset, 0, 10, manaPercentage, barHeight);}
        }
    }

    protected void drawPlayerLevel(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //eventually change to a method to get player level
            Text playerLevel = Text.literal("Level: ");

            int xOffset = ((width - backgroundWidth) / 2) + (backgroundWidth / 2);
            int yOffset = ((height - backgroundHeight) / 2) + 60;
            context.drawText(this.textRenderer, playerLevel, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
        }
    }

    protected void drawPlayerFatigue(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //delete if fatigue is not a future implementation
            float foodLevel = playerEntity.getHungerManager().getFoodLevel();
            //int fatigue = (int) (20 - foodLevel);
            float fatigue = 20 - foodLevel;
            Text playerFatigue = Text.literal("Fatigue: " + fatigue);

            int xOffset = ((width - backgroundWidth) / 2) + (backgroundWidth / 2);
            int yOffset = ((height - backgroundHeight) / 2) + 75;
            context.drawText(this.textRenderer, playerFatigue, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
        }
    }

    protected void drawPlayerStats(DrawContext context){
        drawPlayerStrength(context);
        drawPlayerAgility(context);
        drawPlayerSense(context);
        drawPlayerVitality(context);
        drawPlayerIntelligence(context);
        int xOffset = ((width - backgroundWidth) / 2) + 5;
        int yOffset = ((height - backgroundHeight) / 2) + statHeight - 10;
        int yOffset2 = ((height - backgroundHeight) / 2) + statHeight + 35;
        context.drawTexture(STAT_TEXTURE, xOffset, yOffset, 0, 15, barWidth, barHeight);
        context.drawTexture(STAT_TEXTURE, xOffset, yOffset2, 0, 15, barWidth, barHeight);
    }
    protected void drawPlayerStrength(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //change to method for getting specific stat
            String playerSTR = "##";
            Text playerStrength = Text.literal("STR: " + playerSTR);

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + statHeight;
            context.drawText(this.textRenderer, playerStrength, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            //add the draw stat increase button
        }
    }
    protected void drawPlayerAgility(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //change to method for getting specific stat
            String playerAGI = "##";
            Text playerAgility = Text.literal("AGI: " + playerAGI);

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + statHeight + 15;
            context.drawText(this.textRenderer, playerAgility, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            //add the draw stat increase button
        }
    }
    protected void drawPlayerSense(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //change to method for getting specific stat
            String  playerSNS = "##";
            Text playerSense = Text.literal("SEN: " + playerSNS);

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + statHeight + 30;
            context.drawText(this.textRenderer, playerSense, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            //add the draw stat increase button
        }
    }
    protected void drawPlayerVitality(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //change to method for getting specific stat
            String  playerVIT = "##";
            Text playerVitality = Text.literal("VIT: " + playerVIT);

            int xOffset = ((width - backgroundWidth) / 2) + (backgroundWidth / 2);
            int yOffset = ((height - backgroundHeight) / 2) + statHeight;
            context.drawText(this.textRenderer, playerVitality, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            //add the draw stat increase button
        }
    }

    protected void drawPlayerIntelligence(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //change to method for getting specific stat
            String  playerINT = "##";
            Text playerIntelligence = Text.literal("INT: " + playerINT);

            int xOffset = ((width - backgroundWidth) / 2) + (backgroundWidth / 2);
            int yOffset = ((height - backgroundHeight) / 2) + statHeight + 15;
            context.drawText(this.textRenderer, playerIntelligence, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            //add the draw stat increase button
        }
    }

    protected void drawPlayerPoints(DrawContext context){
        this.playerEntity = this.client.player;
        if (playerEntity != null){
            //change to method for getting total points and points available
            String playerPNT = "##";
            String playerMaxPNT = "##";
            Text playerPoints = Text.literal("Available Points: " + playerPNT + " / " + playerMaxPNT);

            int xOffset = ((width - backgroundWidth) / 2) + 5;
            int yOffset = ((height - backgroundHeight) / 2) + 235;
            context.drawText(this.textRenderer, playerPoints, xOffset, yOffset, 0xFFFFFF, textRenderer.isRightToLeft());
            //add the draw stat increase button
        }
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
