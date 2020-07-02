package contracts.runner;

import contracts.serverest.users.UsersContractTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  UsersContractTests.class,
})
public class AllContractTests {}
