// Native Fetch-based API client with automatic JWT token attachment
const BASE_URL = "http://localhost:8080/api/v1";

export const api = {
    get: async (url) => {
        const token = localStorage.getItem("token");
        const headers = { "Content-Type": "application/json" };
        if (token) {
            headers["Authorization"] = `Bearer ${token}`;
        }
        const res = await fetch(`${BASE_URL}${url}`, {
            method: "GET",
            headers,
        });
        if (!res.ok) {
            const err = await res.json().catch(() => ({}));
            throw new Error(err.message || `Request failed with status ${res.status}`);
        }
        return res.json();
    },

    post: async (url, data) => {
        const token = localStorage.getItem("token");
        const headers = { "Content-Type": "application/json" };
        if (token) {
            headers["Authorization"] = `Bearer ${token}`;
        }
        const res = await fetch(`${BASE_URL}${url}`, {
            method: "POST",
            headers,
            body: JSON.stringify(data),
        });
        if (!res.ok) {
            const err = await res.json().catch(() => ({}));
            throw new Error(err.message || `Request failed with status ${res.status}`);
        }
        return res.json();
    },
};

export default api;
