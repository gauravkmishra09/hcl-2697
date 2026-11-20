import { add, subtract, multiply, divide, isEven } from './math';

describe('Math functions', () => {
  test('add: adds two positive numbers correctly', () => {
    expect(add(2, 3)).toBe(5);
  });

  test('add: works with negative numbers', () => {
    expect(add(-5, 10)).toBe(5);
  });

  test('subtract: subtracts two numbers correctly', () => {
    expect(subtract(10, 4)).toBe(6);
  });

  test('multiply: multiplies two numbers correctly', () => {
    expect(multiply(6, 7)).toBe(42);
  });

  test('divide: divides two numbers correctly', () => {
    expect(divide(20, 4)).toBe(5);
  });

  test('divide: throws error when dividing by zero', () => {
    expect(() => divide(10, 0)).toThrow('Cannot divide by zero');
  });

  test('isEven: returns true for even numbers and false for odd', () => {
    expect(isEven(4)).toBe(true);
    expect(isEven(7)).toBe(false);
  });
});
