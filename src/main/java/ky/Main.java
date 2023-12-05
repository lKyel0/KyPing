package ky;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
public class Main extends PluginBase {

  @Override
  public void onEnable() {
    this.getLogger().info(TextFormat.GREEN + "on");
    registerCommands();
  }

  public void registerCommands() {
    this.getServer().getCommandMap().register("ping", new ky.Commands.PingCommand());
  }

  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "off");
  }
}