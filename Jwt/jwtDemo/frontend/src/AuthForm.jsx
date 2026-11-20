import { useState, useActionState } from "react";
import SubmitButton from "./SubmitButton";

const AuthForm = ({ onLogin, onNotify }) => {
    const [mode, setMode] = useState("login");

    const submitAction = async (prevState, formData) => {
        const username = formData.get("username")?.trim();
        const password = formData.get("password")?.trim();

        if (!username || !password) {
            onNotify?.({
                type: "error",
                message: "Username and password cannot be empty!",
            });
            return null;
        }

        try {
            const url = mode === "login"
                ? "http://localhost:8080/api/v1/auth/login"
                : "http://localhost:8080/api/v1/auth/register";

            const response = await fetch(url, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password }),
            });

            let data = {};
            try {
                data = await response.json();
            } catch (e) {
                data = {};
            }

            // 1. REGISTER FAILURE CHECK
            if (mode === "register") {
                if (data.type === "error") {
                    onNotify?.({
                        type: "error",
                        message: data.message || "Username already in use!",
                    });
                    return null;
                }
                onNotify?.({
                    type: "success",
                    message: data.message || "User successfully registered! Ab login karein.",
                });
                setMode("login");
                return null;
            }

            // 2. LOGIN FAILURE CHECK (Aapke backend me galat login par: token = "error", username = "username or password is incorrect")
            if (mode === "login") {
                if (data.token === "error" || !data.token) {
                    onNotify?.({
                        type: "error",
                        message: data.username || "Username or password is incorrect!",
                    });
                    return null;
                }

                // Agar valid token mila tabhi login hoga
                localStorage.setItem("token", data.token);
                localStorage.setItem("username", data.username || username);

                onNotify?.({
                    type: "success",
                    message: `Welcome back, ${data.username}! Login successful.`,
                });
                if (onLogin) onLogin(data);
            }

            return null;
        } catch (err) {
            onNotify?.({
                type: "error",
                message: "Backend server nahi chal raha (http://localhost:8080). Pehle backend start karein!",
            });
            return null;
        }
    };

    const [, formAction] = useActionState(submitAction, null);

    return (
        <div className="relative z-10 w-full max-w-sm px-2">
            {/* Header */}
            <div className="mb-8">
                <h1 className="text-4xl sm:text-5xl font-extrabold text-slate-900 tracking-tight font-heading">
                    {mode === "login" ? "Sign in to account" : "Create your account"}
                </h1>
                <p className="text-slate-600 text-sm sm:text-base mt-2.5 font-normal">
                    {mode === "login"
                        ? "Enter your credentials below to access your dashboard."
                        : "Fill in the details to register a new user."}
                </p>
            </div>

            {/* Direct Form without card container */}
            <form action={formAction} className="space-y-5">
                <div>
                    <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-1.5">
                        Username
                    </label>
                    <input
                        type="text"
                        name="username"
                        required
                        placeholder="e.g. Vasudev Krishna"
                        className="w-full px-4 py-3 bg-white/90 border border-slate-300 rounded-xl text-slate-900 placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-slate-900 focus:border-slate-900 shadow-sm transition-all"
                    />
                </div>

                <div>
                    <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-1.5">
                        Password
                    </label>
                    <input
                        type="password"
                        name="password"
                        required
                        placeholder="••••••••••••"
                        className="w-full px-4 py-3 bg-white/90 border border-slate-300 rounded-xl text-slate-900 placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-slate-900 focus:border-slate-900 shadow-sm transition-all"
                    />
                </div>

                <div className="pt-2">
                    <SubmitButton />
                </div>
            </form>

            {/* Toggle Mode */}
            <div className="mt-8 text-sm text-slate-600">
                {mode === "login" ? (
                    <>
                        Don't have an account?{" "}
                        <button
                            type="button"
                            onClick={() => setMode("register")}
                            className="text-slate-900 font-bold hover:underline cursor-pointer ml-1"
                        >
                            Sign up here
                        </button>
                    </>
                ) : (
                    <>
                        Already registered?{" "}
                        <button
                            type="button"
                            onClick={() => setMode("login")}
                            className="text-slate-900 font-bold hover:underline cursor-pointer ml-1"
                        >
                            Log in instead
                        </button>
                    </>
                )}
            </div>
        </div>
    );
};

export default AuthForm;