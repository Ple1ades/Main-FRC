package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase{
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Shooter m_shooter;
    public Shoot(Shooter shooter){
        m_shooter = shooter;
        addRequirements(shooter);
    }
    
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_shooter.setShooter(Constants.Shooter.maxRPM, 5000);
        if (m_shooter.getVelocity() >= Constants.Shooter.maxRPM/4){
            m_shooter.beltStop();
        }
        // m_shooter.beltDown();
    }

    @Override
    public void end(boolean interrupted){
        m_shooter.resetShooter();
        m_shooter.beltUp();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
