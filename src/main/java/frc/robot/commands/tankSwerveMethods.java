package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubsystemCommands.tankSwerveCommands;
import frc.robot.subsystems.tankSwerve;

public class tankSwerveMethods extends Command{
    tankSwerve tankSwerve;
    Joystick joystick;

    public tankSwerveMethods(tankSwerve tankSwerve, Joystick joystick) {
        this.tankSwerve = tankSwerve;
        this.joystick = joystick;
        addRequirements(tankSwerve);
    }

    @Override
    public void execute() {
        if (joystick.getRawAxis(CommandConstants.AxisLeftStickY) != 0) {
            tankSwerveCommands command = new tankSwerveCommands(joystick.getRawAxis(CommandConstants.AxisLeftStickY), joystick.getRawAxis(CommandConstants.AxisLeftStickX), tankSwerve);
            command.execute();
        }
        else{
            tankSwerveCommands command = new tankSwerveCommands(joystick.getRawAxis(CommandConstants.AxisLeftStickY), joystick.getRawAxis(CommandConstants.AxisLeftStickX), tankSwerve);
            command.stop();
        }
    }
}
