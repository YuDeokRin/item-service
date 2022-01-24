package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {
    /**
     * 실무에서는 HashMap<> 사용 X  , Why? 동시에 여러 쓰레드(멀티쓰레드)가 접근할 떄가 store에 한번에 접근하게되면 안된다.
     * ItemRepository는  singleton 으로 생성되기 때문이다.
     * 해결 : ConcurrentHashMap<>, AtomicLong()을 사용하면된다.
     */

    private static final Map<Long, Item> store = new HashMap<>();  // static
    private static long sequence = 0L ; // static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        //store를 바로 collcation으로 반환하여도되는데 ArrayList로 감싸서 반환하게 되면, ArrayList에 값을 넣어도 store에 영향을 주지않기 떄문에 감싸서 반환한다.
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }
}
