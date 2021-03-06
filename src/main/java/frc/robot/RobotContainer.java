// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.Drivetrain;
import frc.robot.commands.Kill;
import frc.robot.commands.PneumaticMoveForward;
import frc.robot.commands.PneumaticMoveReverse;

// import frc.robot.commands.InverseVisionAlign;
// import frc.robot.commands.PIDAuto;
import frc.robot.commands.Shoot;
// import frc.robot.commands.Belt;
// import frc.robot.commands.BeltStop;
import frc.robot.commands.ShootStop;
import frc.robot.commands.VisionAlign;
import frc.robot.commands.VisionFollow;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Pneumatic;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
// import frc.robot.commands.InverseVisionAlign;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */


public class RobotContainer {
  
  // The robot's subsystems and commands are defined here...
  public final Shooter m_shooter = new Shooter();
  public final DrivetrainSubsystem m_drive = new DrivetrainSubsystem();
  
  private final XboxController m_XboxController = new XboxController(0);
  
  public final Pneumatic m_piston = new Pneumatic();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drive.setDefaultCommand(
      new Drivetrain(m_drive, () -> m_XboxController.getY(Hand.kLeft), 
      () -> m_XboxController.getX(Hand.kRight))
      );
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(
         m_XboxController, 
         Button.kX.value).whenPressed(
           new PneumaticMoveForward(m_piston),true
       ).whenReleased(
         new PneumaticMoveReverse(m_piston), true
    );
    // vision A = aling,
    // vision Y = follow
    // new JoystickButton(m_XboxController, Button.kA.value).whenHeld(new VisionAlign(m_drive), true);
    // new JoystickButton(m_XboxController, Button.kY.value).whenHeld(new VisionFollow(m_drive), true);
    
    // new JoystickButton(m_XboxController, Button.kB.value).whenHeld(new Kill(m_drive), true);
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
  //  * @return the command to run in autonomous
  //  */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return null;
  // }

  public DrivetrainSubsystem getDriveTrain() {
    return m_drive;

  }

  public Pneumatic getPnumatic(){
    return m_piston; 

  }

  // public PIDAuto getAutonomousCommand() {
  //   return m_drive;

  // }
}
