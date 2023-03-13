package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase{
    public DriveTrain() {
        backLeftMotor.setInverted(true);
        frontLeftMotor.setInverted(true);

        backLeftMotor.configOpenloopRamp(0.1);
        backRightMotor.configOpenloopRamp(0.1);
        frontRightMotor.configOpenloopRamp(0.1);
        frontLeftMotor.configOpenloopRamp(0.1);
    }

    private final WPI_TalonFX frontLeftMotor = new WPI_TalonFX(Constants.ports.frontLeft);
    private final WPI_TalonFX frontRightMotor = new WPI_TalonFX(Constants.ports.frontRight);
    private final WPI_TalonFX backLeftMotor = new WPI_TalonFX(Constants.ports.backLeft);
    private final WPI_TalonFX backRightMotor = new WPI_TalonFX(Constants.ports.backRight);

    private final MotorControllerGroup leftSpeedGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    private final MotorControllerGroup rightSpeedGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);

    private final DifferentialDrive drive = new DifferentialDrive(leftSpeedGroup, rightSpeedGroup);

   // private final boolean breaksOn = true;

  public void turnDrive(double forwardPercent, double rotationPercent) {
    drive.arcadeDrive(forwardPercent, rotationPercent);
  }
  public void tankDrive(double leftPercent, double rightPercent) {
    drive.tankDrive(leftPercent, rightPercent);
  }

    public void exitBreak(){
      frontLeftMotor.setNeutralMode(NeutralMode.Coast);
      frontRightMotor.setNeutralMode(NeutralMode.Coast);
      backLeftMotor.setNeutralMode(NeutralMode.Coast);
      backRightMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void enterBreak(){
      frontLeftMotor.setNeutralMode(NeutralMode.Brake);
      frontRightMotor.setNeutralMode(NeutralMode.Brake);
      backLeftMotor.setNeutralMode(NeutralMode.Brake);
      backRightMotor.setNeutralMode(NeutralMode.Brake);
    }
    public void stop(){
      drive.arcadeDrive(0, 0);
    }



}
