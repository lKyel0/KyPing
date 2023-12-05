package ky.Commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class PingCommand extends Command {
  public PingCommand() {
    super("ping");
    this.setDescription("Muestra el ping del jugador actual o de otro jugador si se especifica.");
  }

  @Override
  public boolean execute(CommandSender sender, String s, String[] strings) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(TextFormat.RED + "Este comando solo puede ser ejecutado por jugadores.");
      return false;
    }

    Player player = (Player) sender;

    Player targetPlayer = (strings.length > 0) ? sender.getServer().getPlayer(strings[0]) : null;

    if (targetPlayer != null && !targetPlayer.equals(player)) {
      int ping = targetPlayer.getPing();
      TextFormat color = getColorByPing(ping);

      player.sendMessage(TextFormat.WHITE + "El ping de " + TextFormat.GRAY + targetPlayer.getName() + " es: " + color + ping + TextFormat.WHITE + " ms");
    } else {
      int ping = player.getPing();
      TextFormat color = getColorByPing(ping);

      player.sendMessage(TextFormat.WHITE + "Tu ping es: " + color + ping + TextFormat.WHITE + " ms");
    }
    return true;
  }

  private TextFormat getColorByPing(int ping) {
    if (ping >= 0 && ping <= 90) {
      return TextFormat.GREEN;
    } else if (ping > 90 && ping <= 130) {
      return TextFormat.YELLOW;
    } else {
      return TextFormat.RED;
    }
  }
}
