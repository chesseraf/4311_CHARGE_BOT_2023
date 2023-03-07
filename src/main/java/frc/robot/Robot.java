// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveTrain;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private RobotContainer robotContainer;

    private  Command armCommand=robotContainer.GetArmCommand();
    private  Command autoBalanceCommand=robotContainer.GetAutoBalanceCommand();
    private  Command autoPlaceCommand=robotContainer.GetAutoPlaceCommand();
    private Command balanceDriveCommand=robotContainer.GetBalanceDriveCommand();
    private  Command teleopCommand=robotContainer.GetTeleopCommand();
    private  Command putConeCommand=robotContainer.GetPutConeCommand();
    private Command wingFlapCommand=robotContainer.GetWingFlapCommand();

  //auto chooser
  private static final String balanceAuto = "Default";
  private static final String placeAuto = "My Auto";
  private String autoChosen;
  private final SendableChooser<String> autoChoice = new SendableChooser<>();

  @Override
  public void robotInit() {
    final double calibratedGyro =robotContainer.GYRO.getAngle();
    robotContainer = new RobotContainer();

    autoChoice.setDefaultOption("balance", balanceAuto);
    autoChoice.addOption("place", placeAuto);
    SmartDashboard.putData("Auto choices", autoChoice);
  }

  @Override
  public void robotPeriodic() {
    robotContainer.UpdateJoystick();
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autoChosen = autoChoice.getSelected();
    System.out.println("Auto selected: " + autoChosen);

    switch (autoChosen) {
      case balanceAuto:
        // Put custom auto code here
        System.out.println("balancing");
//        CommandScheduler.getInstance().schedule(new autoBalance());
        break;
      case placeAuto:
      default:
        // Put default auto code here
        System.out.println("just placing");

        break;
    }   
    
  }

  @Override
  public void autonomousPeriodic() {}
    
  @Override
  public void teleopInit() {
    teleopCommand.schedule();
    

    wingFlapCommand.schedule();


  }

  @Override
  public void teleopPeriodic() {
   // System.out.println("get rate " + gyro.getRate());
   // System.out.println("get angle " + gyro.getAngle());

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    System.out.println("testing");
  }

  @Override
  public void testPeriodic() {

    //check number of each button
    
      for(int i=0; i<20; i++){
        if(RobotContainer.THRUSTMASTER.getRawButton(i)){
          System.out.println("button" + i);
        }
      }      
    //check gyroValues when gyroButton pressed
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}