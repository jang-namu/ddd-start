package org.example.dddstart.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Receiver {
    private String name;
    private String phone;

    /*
    지연로딩 = 클래스를 상속한 프록시 객체 사용 => 프록시 클래스에서 상위 클래스의 기본 생성자 호출이 가능해야함
    따라서 지연로딩의 대상인 @Entity와 @Embeddable의 기본 생성자는 private이 아닌 protected가 되어야 함.
     */
    protected Receiver() {} // JPA를 사용하기 위한 기본 생성자 (원래 불변 타입에는 필요없음)

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
