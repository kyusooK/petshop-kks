package petshop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository
    extends PagingAndSortingRepository<Item, Long> {}
