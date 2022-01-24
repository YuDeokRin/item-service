package hello.itemservice.domain.item;


import lombok.Data;

@Data  //  @Data는 함부로 쓰는것은 위험하다. 이유는 예측하지 못하게 동작을 하기 때문에 조심히 써야한다.
//@Getter @Setter // 실무에서는 따로 써주는 것이 좋음.
public class Item {

    private Long id;
    private String itemName;
    private Integer price; //int를 쓰지않는 이유는 수량이 null로 값이 들어갈 수 도있기 때문이다. int를 쓸 경우  0이라도 들어가야된다.
    private Integer quantity;  //int를 쓰지않는 이유는 수량이 null로 값이 들어갈 수 도있기 때문이다. int를 쓸 경우  0이라도 들어가야된다.

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
