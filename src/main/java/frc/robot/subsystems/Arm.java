package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    private WPI_TalonFX armTalon;

    public Arm(WPI_TalonFX tal){
        armTalon = tal;
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
        armTalon.configForwardSoftLimitThreshold(4000);
        armTalon.configReverseSoftLimitThreshold(0);
        armTalon.configReverseSoftLimitEnable(true);
        armTalon.configForwardSoftLimitEnable(true);
    }  
    public void ReachOut(){
        armTalon.set(Constants.ARM_SPEED);
    }
    public void ReachIn(){
        armTalon.set(-Constants.ARM_SPEED);
    }

    public void stop(){
        armTalon.set(0);
    }
}
