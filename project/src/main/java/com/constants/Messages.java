package com.constants;

public enum Messages {
    
    OutOfRangeError("A propriedade \"%s\" de \"%s\" não pode ser menor do que zero."),
    InvalidIndexError("Índice recebido na propriedade \"%s\" inválido. Ele deve ser maior que \"%d\" e menor que \"d%\"."),
    CannotBeNull("A propriedade \"%s\" de \"%s\" não pode receber valores nulos."),
    MaxValueExceeded("Não foi possível adicionar o \"%s\" na propriedade \"%s\". Valor máximo excedido."),
    CannotBeSameError("As propriedades \"%s\" e \"%s\" não podem ser iguais."),
    CannotBeAbove("O valor da propriedade \"%s\" de \"%s\" não pode ser menor do que o valor de \"%s\".");

    public final String message;

    Messages(String message) {

        this.message = message;

    }

    public String getMessage() {

        return this.message;

    } 

}
