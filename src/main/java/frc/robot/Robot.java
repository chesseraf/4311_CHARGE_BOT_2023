// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.sound.midi.SysexMessage;

import edu.wpi.first.wpilibj.Compressor;
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

  private Command autoCommand;
  private Command  teleopCommand;

  //auto chooser
  private static final String balanceAuto = "Default";
  private static final String placeAuto = "My Auto";
  private String autoChosen;
  private final SendableChooser<String> autoChoice = new SendableChooser<>();
  //private final Command teleop;

// public Compressor comp;
 public static DoubleSolenoid leftWing;
 public static DoubleSolenoid rightWing;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();

    autoChoice.setDefaultOption("balance", balanceAuto);
    autoChoice.addOption("place", placeAuto);
    SmartDashboard.putData("Auto choices", autoChoice);
    System.out.println("enabling comp robot");
    //robotContainer.comp.enableDigital();
    System.out.print("line 72 comp");
  }


  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //comp.enableDigital();
    robotContainer.updateJoystick();
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
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
     autoCommand = robotContainer.getAutoCommand();
     autoCommand.schedule();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}
  

  /** This function is called once when teleop is enabled. */
  
  @Override
  public void teleopInit() {
    robotContainer.flaperCommand.schedule();
    teleopCommand = robotContainer.getTeleopCommand();
    teleopCommand.schedule();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
   // System.out.println("get rate " + gyro.getRate());
   // System.out.println("get angle " + gyro.getAngle());

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
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
    
    /*  for(int i=0; i<20; i++){
         if(thrustMaster.getRawButton(i)){
          System.out.println("button" + i);
        }
      }      
 */   //check gyroValues when gyroButton pressed
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
