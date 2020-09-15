package allrunners;

import contracts.runner.AllContractIT;
import integrations.runner.AllIntegrationIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AllContractIT.class,
  AllIntegrationIT.class,
})
public class AllIT {}
