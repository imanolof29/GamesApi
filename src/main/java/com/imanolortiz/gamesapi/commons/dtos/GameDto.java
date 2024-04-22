package com.imanolortiz.gamesapi.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameDto {

    private Long id;

    private String name;

    private double price;

}
