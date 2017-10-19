package lab.aop;

import lab.model.Customer;
import lab.model.CustomerBrokenException;
import lab.model.Squishee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Politeness {

  @Pointcut("execution(* sellSquishee(..))")
  public void sellSquishee() {
  }

  @Before("sellSquishee()")
  public void sayHello(JoinPoint joinPiont) {
    AopLog.append(
        "Hello " + ((Customer) joinPiont.getArgs()[0]).getName() + ". How are you doing? \n");
  }

  @AfterReturning(pointcut = "sellSquishee()", returning = "retVal", argNames = "retVal")
  public void askOpinion(Squishee retVal) {
    AopLog.append("Is " + retVal.getName() + " Good Enough? \n");
  }

  @AfterThrowing(pointcut = "sellSquishee()", throwing = "e")
  public void sayYouAreNotAllowed(CustomerBrokenException e) {
    AopLog.append("Hmmm... \n");
  }

  @After("sellSquishee()")
  public void sayGoodBye() {
    AopLog.append("Good Bye! \n");
  }

  @Around("sellSquishee()")
  public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
    AopLog.append("Hi! \n");
    Object retVal = pjp.proceed();
    AopLog.append("See you! \n");
    return retVal;
  }
}