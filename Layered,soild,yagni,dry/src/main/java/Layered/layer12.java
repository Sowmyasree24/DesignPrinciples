package Layered;

import Layered.Objects.CustomerAddMoneyDTO;
import Layered.Objects.CustomerEntity;

@Controller
@RequiredArgsConstructor
public class layer12 {
	private final layer12 customerService;

	  @PostMapping(value = "/customers/add-money")
	  public @ResponseBody CustomerAddMoneyDTO addMoney(@RequestBody CustomerAddMoneyDTO dto) {
	    return customerService.addFundsToCustomer(dto);
	  }

	private CustomerAddMoneyDTO addFundsToCustomer(CustomerAddMoneyDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	  
}
class Objects {
	class CustomerAddMoneyDTO {
		  
		  public String username;
		  public Integer moneyAmount;
		  
		}

		class Customer {
		  
		  public String username;
		  public String password;
		  public String moneyAmount;
		  
		}

		@Entity
		@Table(name="CUSTOMER")
		class CustomerEntity {
		  
		  @Id
		  @GeneratedValue(strategy=GenerationType.AUTO)
		  public Long id;
		   
		  @Column(name="USERNAME")
		  public String username;
		  
		  @Column(name="PASSWORD")
		  public String password;
		  
		  @Column(name="MONEY_AMOUNT")
		  public Integer moneyAmount;

		public Object getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getMoneyAmount() {
			// TODO Auto-generated method stub
			return null;
		}
		  
		}

}







	@Component
	class CustomerMapper {
	  
	  public CustomerAddMoneyDto mapToDto(CustomerEntity customerEntity) {
	    CustomerAddMoneyDto dto = new CustomerAddMoneyDto();
	    dto.username = customerEntity.getUsername();
	    dto.moneyAmount = customerEntity.getMoneyAmount();
	    return dto;
	  }
	  
	}

	@Service
	@AllArgsConstructor
	class CustomerService {
	  
	  private final CustomerRepository customerRepository;
	  private final CustomerMapper customerMapper;
	  
	  public CustomerAddMoneyDto addFundsToCustomer(
	    CustomerAddMoneyDto dto) {
	  
	    CustomerEntity customerEntity = customerRepository.findByUsername(dto.getUsername());
	    customerEntity.moneyAmount += dto.getMoneyAmount();
	    return customerMapper.mapToDto(customerRepository.save(customerEntity));
	  }
	  
	}
}
