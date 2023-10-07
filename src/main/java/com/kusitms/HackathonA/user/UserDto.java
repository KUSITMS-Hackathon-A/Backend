package com.kusitms.HackathonA.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
public class UserDto {

    @NoArgsConstructor
    @Data
    public static class Request{

        private String id;
        private String password;
        private String name;
        private String zipCode;
        private String address;
        private String phone;

        public Request(UserEntity userEntity) {
            this.id=userEntity.getId();
            this.password=userEntity.getPassword();
            this.name=userEntity.getName();
            this.zipCode=userEntity.getZipCode();
            this.address=userEntity.getAddress();
            this.phone=userEntity.getPhone();
        }

        public UserEntity toEntity() {
            return UserEntity.builder()
                    .id(id)
                    .password(password)
                    .name(name)
                    .zipCode(zipCode)
                    .address(address)
                    .phone(phone)
                    .useyn(1L)
                    .regDate(new Date())
                    .build();
        }

    }
}
