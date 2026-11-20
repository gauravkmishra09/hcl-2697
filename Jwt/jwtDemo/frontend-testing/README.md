# Testing Notes

## Types of Testing
1. **Unit Testing** -> Testing individual units/functions in isolation.
2. **Integration Testing** -> Combining multiple units and testing their interactions.
3. **End to End (E2E) Testing** -> Testing the complete workflow from start to finish.

---

## 1. Node.js Built-in Test Runner
Node.js supports a built-in testing framework out of the box (Node >= 23):

```bash
# In node-test folder:
npm init -y
```

### `app.js`:
```javascript
export const greet = (name) => {
  return `Hello, ${name}`;
};
// 'export' signifies that the method can be used by other files
```

### Run Tests:
```bash
npm test
```

---

## 2. Jest Framework with React and Vite
To set up Jest in a React + Vite application:

### Step 1: Create React App
```bash
npm create vite@latest test-demo-react
```

### Step 2: Install Developer Dependencies
```bash
npm install -D jest babel-jest @babel/core@^7 @babel/preset-env@^7 @babel/preset-react@^7
npm install -D jest-environment-jsdom @testing-library/react @testing-library/jest-dom @testing-library/user-event
npm install -D identity-obj-proxy
```

### Step 3: Add Configuration Files

#### 1. `babel.config.js` (in root folder)
```javascript
export default {
  presets: [
    [
      "@babel/preset-env",
      {
        targets: { node: "current" },
      },
    ],
    [
      "@babel/preset-react",
      {
        runtime: "automatic",
      },
    ],
  ],
};
```

#### 2. `jest.config.js` (in root folder)
```javascript
export default {
  testEnvironment: "jsdom",
  transform: {
    "^.+\\.[jt]sx?$": "babel-jest",
  },
  setupFilesAfterEnv: ["<rootDir>/src/setupTests.js"],
  moduleNameMapper: {
    "\\.(css|less|scss)$": "identity-obj-proxy",
  },
};
```

#### 3. `src/setupTests.js`
```javascript
import '@testing-library/jest-dom';
```

### Step 4: Update `package.json` Scripts
```json
"scripts": {
  "dev": "vite",
  "test": "jest",
  "test:watch": "jest --watch",
  "test:coverage": "jest --coverage",
  "build": "vite build",
  "lint": "eslint .",
  "preview": "vite preview"
}
```
