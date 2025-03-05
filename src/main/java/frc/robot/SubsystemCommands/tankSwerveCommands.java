package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.tankSwerve;

public class tankSwerveCommands extends Command{
    double turn;
    double power;
    tankSwerve tankSwerve;
    
    public tankSwerveCommands(double speed, double turn, tankSwerve tankSwerve) {
        this.turn = turn;
        this.power = speed;
        this.tankSwerve = tankSwerve;
        addRequirements(tankSwerve);
    }

    public void execute() {
        tankSwerve.move(power, turn);
    }

    public void stop() {
        tankSwerve.move(0, 0);
    } 
}
