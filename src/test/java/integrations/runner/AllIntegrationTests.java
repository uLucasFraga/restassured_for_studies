package integrations.runner;

import integrations.serverest.carts.DeleteCartsTests;
import integrations.serverest.carts.GetCartsTests;
import integrations.serverest.login.PostLoginTests;
import integrations.serverest.products.GetProductsTests;
import integrations.serverest.users.PostUsersTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GetCartsTests.class,
  GetProductsTests.class,
  PostLoginTests.class,
  DeleteCartsTests.class,
  PostUsersTests.class,
})
public class AllIntegrationTests {}
