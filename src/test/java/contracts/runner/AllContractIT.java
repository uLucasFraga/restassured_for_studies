package contracts.runner;

import contracts.serverest.carts.CartsContractIT;
import contracts.serverest.users.UsersContractIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UsersContractIT.class, CartsContractIT.class, UsersContractIT.class})
public class AllContractTests {}
