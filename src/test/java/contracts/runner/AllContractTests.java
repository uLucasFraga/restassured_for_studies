package contracts.runner;

import contracts.serverest.users.UsersContract;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  UsersContract.class,
})
public class AllContractTests {}
