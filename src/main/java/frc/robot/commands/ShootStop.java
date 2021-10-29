package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;


public class ShootStop extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Shooter m_shooter;
  

  public ShootStop(Shooter subsystem) {
    m_shooter = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_shooter.resetShooter();
    m_shooter.beltStop();
  }

  @Override
  public void end(boolean interrupted) {
    m_shooter.resetShooter();
    m_shooter.beltStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}