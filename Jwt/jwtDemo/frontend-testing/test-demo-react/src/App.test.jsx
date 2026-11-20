import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Get started heading', () => {
  render(<App />);
  const headingElement = screen.getByText(/Get started/i);
  expect(headingElement).toBeInTheDocument();
});
