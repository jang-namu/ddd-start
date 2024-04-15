package org.example.dddstart.order.domain;

import jakarta.persistence.*;

@Embeddable
public class Orderer {

    /*
    MemberId에 정의된 칼럼 이름을 변경하기 위해 @AttributeOverrides 사용
     */
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private final MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

}