package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveConstants;

public class tankSwerve extends SubsystemBase{

    //Define Motor Constructor
    private SparkMax leftBack = new SparkMax(SwerveConstants.LEFT_BACK_DRIVE_ID, MotorType.kBrushless);
    private SparkMax leftFront = new SparkMax(SwerveConstants.LEFT_FRONT_DRIVE_ID, MotorType.kBrushless);
    private SparkMax rightBack = new SparkMax(SwerveConstants.RIGHT_BACK_DRIVE_ID, MotorType.kBrushless);
    private SparkMax rightFront = new SparkMax(SwerveConstants.RIGHT_FRONT_DRIVE_ID, MotorType.kBrushless);
    private SparkMax leftFrontTurn = new SparkMax(SwerveConstants.LEFT_FRONT_TURN_ID, MotorType.kBrushless);
    private SparkMax leftBackTurn = new SparkMax(SwerveConstants.LEFT_BACK_TURN_ID, MotorType.kBrushless);
    private SparkMax rightBackTurn = new SparkMax(SwerveConstants.RIGHT_BACK_TURN_ID, MotorType.kBrushless);
    private SparkMax rightFrontTurn = new SparkMax(SwerveConstants.RIGHT_FRONT_TURN_ID, MotorType.kBrushless);

    public tankSwerve(){
        SparkMaxConfig config = new SparkMaxConfig();
        config
            .inverted(true)
            .idleMode(IdleMode.kBrake);
        config.encoder
            .positionConversionFactor(1000)
            .velocityConversionFactor(1000);
        config.closedLoop
            .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
            .pid(1.0, 0.0, 0.0);
            
        leftBack.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFront.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightBack.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFront.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftBackTurn.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFrontTurn.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightBackTurn.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFrontTurn.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
    }
    public void move(double speed, double turn){
        leftBack.set(speed + turn);
        leftFront.set(speed + turn);
        rightBack.set(speed - turn);
        rightFront.set(speed - turn);
        SmartDashboard.putNumber("leftBack Speed", leftBack.get());
    }
    public void stop(){
        //Stops Motor
        leftBack.set(0);
        leftFront.set(0);
        rightBack.set(0);
        rightFront.set(0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("leftBack Speed", leftBack.get());
    }
}
