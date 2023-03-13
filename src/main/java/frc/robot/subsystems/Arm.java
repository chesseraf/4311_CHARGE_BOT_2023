package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.ArmHighThrow;
import frc.robot.commands.ArmLowPlace;
import frc.robot.commands.ArmMidPlace;

public class Arm extends SubsystemBase{
    public WPI_TalonFX armTalon;
    private DoubleSolenoid holdPieceSol;
    private boolean armIsInside=true;
    private boolean armIsTighten=true;
    public static boolean armExecutingCommand = false;

    public Arm(WPI_TalonFX tal, DoubleSolenoid HoldPiece){
        armTalon = tal;
        holdPieceSol = HoldPiece;
        armTalon.configFactoryDefault();

        armTalon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

        armTalon.setNeutralMode(NeutralMode.Brake);
        armTalon.enableVoltageCompensation(true);
        armTalon.configVoltageCompSaturation(12);
        armTalon.setNeutralMode(NeutralMode.Brake);
        armTalon.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true,70,3,1));
        armTalon.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true,40,3,1));

        armTalon.config_kP(0,0.1);
        armTalon.config_kI(0, 0);
        armTalon.config_kD(0, 0);
        armTalon.config_kF(0, 0);

        final double startingPositionTalonUnits = 0;
        armTalon.setSelectedSensorPosition(startingPositionTalonUnits);
        armTalon.configClosedloopRamp(0.3);
        armTalon.configForwardSoftLimitThreshold(0);
        armTalon.configReverseSoftLimitThreshold(-250000);
        armTalon.configReverseSoftLimitEnable(true);
        armTalon.configForwardSoftLimitEnable(true);
    }

    public boolean ArmIsTight(){
        return(armIsTighten);
    }
    public boolean ArmIsInside(){
        return(armIsInside);
    }
    public void ReachOut(){
        armTalon.set(-Constants.ARM_SPEED);
    }
    public void ReachIn(){
        armTalon.set(Constants.ARM_SPEED);
    }
    public void GoHigh(){
        Robot.shootHighCommand.schedule();
        //CommandScheduler.getInstance().schedule(new ArmHighThrow(this));
    }
    public void GoMid(){
        Robot.shootMidCommand.schedule();
       // CommandScheduler.getInstance().schedule(new ArmMidPlace(this));
    }
    public void GoLow(){
        Robot.shootLowCommand.schedule();
        //CommandScheduler.getInstance().schedule(new ArmLowPlace(this));

    }
    public void Untighten(){
        holdPieceSol.set(DoubleSolenoid.Value.kReverse);
        armIsTighten=false;
    }
    public void Tighten(){
        holdPieceSol.set(DoubleSolenoid.Value.kForward);
        armIsTighten = true;
    }

    public void stop(){
        armTalon.set(0);
    }
}
