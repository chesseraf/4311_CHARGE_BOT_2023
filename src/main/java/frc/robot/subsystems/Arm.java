package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    private WPI_TalonFX armTalon;// = new WPI_TalonFX(Constants.ports.arm);

    public Arm(WPI_TalonFX tal){
        armTalon = tal;
    }
    public void ReachOut(){
        armTalon.set(0.2);
    }
    public void ReachIn(){
        armTalon.set(-0.2);

    }
}
