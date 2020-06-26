package allrunners;

import contracts.runner.AllContractTests;
import integrations.runner.AllIntegrationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AllContractTests.class,
  AllIntegrationTests.class,
})
public class AllTests {}
