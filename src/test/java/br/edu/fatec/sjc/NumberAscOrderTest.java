package br.edu.fatec.sjc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class NumberAscOrderTest {

    private CustomStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new CustomStack<>(6, element -> element);  // Exemplo simples de CalculableStrategy
    }

    @Test
    void testSortWithNumbers() throws StackFullException, StackEmptyException {
        // Adiciona 6 números sorteados aleatoriamente
        stack.push(35);
        stack.push(12);
        stack.push(60);
        stack.push(7);
        stack.push(25);
        stack.push(19);

        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(stack);
        List<Integer> sortedList = numberAscOrder.sort();

        // Verifica se a lista está ordenada de forma crescente
        List<Integer> expectedList = Arrays.asList(7, 12, 19, 25, 35, 60);
        Assertions.assertEquals(expectedList, sortedList);
    }

    @Test
    void testSortWithEmptyStack() throws StackEmptyException {
        // Pilha vazia
        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(stack);
        List<Integer> sortedList = numberAscOrder.sort();

        // Verifica se a lista retornada está vazia
        Assertions.assertTrue(sortedList.isEmpty());
    }
}
