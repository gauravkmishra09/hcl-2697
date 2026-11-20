import React, { useState, useEffect } from 'react'
import AuthForm from './AuthForm'
import PostForm from './PostForm'
import Toast from './Toast'
import { api } from './Api'

// Bade flowers (~1 inch+), high density & quantity
const FLOWERS = [
    { emoji: "🌸", left: "2%", size: "5.5rem", duration: "14s", delay: "0s" },
    { emoji: "🌻", left: "10%", size: "6.2rem", duration: "18s", delay: "2.5s" },
    { emoji: "🪷", left: "18%", size: "5.8rem", duration: "16s", delay: "5s" },
    { emoji: "🌺", left: "26%", size: "6.4rem", duration: "20s", delay: "1s" },
    { emoji: "🌼", left: "34%", size: "5.2rem", duration: "15s", delay: "4s" },
    { emoji: "🌸", left: "42%", size: "6.0rem", duration: "17s", delay: "7s" },
    { emoji: "🌻", left: "50%", size: "6.5rem", duration: "19s", delay: "2s" },
    { emoji: "🪷", left: "58%", size: "5.6rem", duration: "16s", delay: "6s" },
    { emoji: "🌺", left: "66%", size: "6.2rem", duration: "21s", delay: "3.5s" },
    { emoji: "🌼", left: "74%", size: "5.4rem", duration: "15s", delay: "8s" },
    { emoji: "🌸", left: "82%", size: "6.3rem", duration: "18s", delay: "1.5s" },
    { emoji: "🌻", left: "90%", size: "5.9rem", duration: "16s", delay: "4.5s" },
    { emoji: "🪷", left: "96%", size: "6.1rem", duration: "22s", delay: "0.5s" },
    { emoji: "🌺", left: "14%", size: "6.5rem", duration: "19s", delay: "9s" },
    { emoji: "🌸", left: "46%", size: "5.7rem", duration: "17s", delay: "10s" },
    { emoji: "🌼", left: "78%", size: "6.2rem", duration: "18s", delay: "11s" },
]

const App = () => {
    const [user, setUser] = useState(() => {
        const token = localStorage.getItem("token")
        const username = localStorage.getItem("username")
        return token && token !== "error" ? { token, username } : null
    })
    const [posts, setPosts] = useState([])
    const [notification, setNotification] = useState(null)

    const notify = (notif) => {
        setNotification(null)
        setTimeout(() => {
            setNotification(notif)
        }, 10)
    }

    const loadPosts = async () => {
        try {
            const data = await api.get("/posts")
            setPosts(Array.isArray(data) ? data : [])
        } catch (err) {
            console.error("Failed to fetch posts:", err)
        }
    }

    useEffect(() => {
        loadPosts()
    }, [])

    const handleLogin = (data) => {
        setUser(data)
        loadPosts()
    }

    const handleLogout = () => {
        localStorage.removeItem("token")
        localStorage.removeItem("username")
        setUser(null)
        notify({
            type: "success",
            message: "Logged out successfully.",
        })
    }

    const handlePostCreated = async (newPost) => {
        await loadPosts()
    }

    return (
        <div className="relative min-h-screen overflow-x-hidden bg-slate-100 flex flex-col">
            {/* Floating Glassmorphic Toast Notification */}
            <Toast notification={notification} onClose={() => setNotification(null)} />

            {/* Background elements */}
            <div className="absolute top-0 right-0 w-[500px] h-[500px] bg-sky-200/40 rounded-full blur-3xl pointer-events-none"></div>
            <div className="absolute bottom-0 left-0 w-[550px] h-[550px] bg-slate-200/60 rounded-full blur-3xl pointer-events-none"></div>

            {/* Big Floating Flowers */}
            {FLOWERS.map((flower, idx) => (
                <span
                    key={idx}
                    className="floating-flower select-none"
                    style={{
                        left: flower.left,
                        fontSize: flower.size,
                        animationDuration: flower.duration,
                        animationDelay: flower.delay,
                    }}
                >
                    {flower.emoji}
                </span>
            ))}

            {/* Fixed Top Header (Only when logged in) */}
            {user && (
                <header className="fixed top-0 left-0 right-0 z-40 bg-white/70 backdrop-blur-xl border-b border-slate-200/60 shadow-xs">
                    <div className="max-w-6xl mx-auto px-6 py-4 flex items-center justify-between">
                        <div className="flex items-center gap-3">
                            <h2 className="text-xl sm:text-2xl font-bold text-slate-900 font-heading">
                                Hello, {user.username || "Prakhar Tiwari"}
                            </h2>
                        </div>
                        <button
                            onClick={handleLogout}
                            className="px-4 py-2 bg-slate-900 hover:bg-slate-800 text-white rounded-xl text-xs font-bold uppercase tracking-wider transition cursor-pointer shadow-sm active:scale-95"
                        >
                            Sign Out
                        </button>
                    </div>
                </header>
            )}

            {/* Main Content Area */}
            <div className={`relative z-10 w-full flex-1 flex items-center justify-center p-6 sm:p-12 ${user ? "pt-28" : ""}`}>
                <div className="w-full max-w-6xl">
                    {user ? (
                        /* 2-Column Split: Left = Create Post, Right = Recent Posts */
                        <div className="grid grid-cols-1 lg:grid-cols-12 gap-8 lg:gap-12 items-start">
                            {/* Left Side: Create Post Form */}
                            <div className="lg:col-span-5">
                                <PostForm onCreated={handlePostCreated} onNotify={notify} />
                            </div>

                            {/* Right Side: Recent Posts Feed */}
                            <div className="lg:col-span-7">
                                <div className="flex items-center justify-between mb-4">
                                    <h3 className="text-2xl font-bold text-slate-900 font-heading">
                                        Recent Posts
                                    </h3>
                                    <span className="text-xs font-bold px-2.5 py-1 bg-slate-200 rounded-lg text-slate-700">
                                        {posts.length} {posts.length === 1 ? "Post" : "Posts"}
                                    </span>
                                </div>

                                {posts.length === 0 ? (
                                    <div className="p-8 text-center bg-white/60 backdrop-blur-md rounded-2xl border border-dashed border-slate-300">
                                        <p className="text-slate-500 text-sm font-medium">
                                            No posts yet. Write your first post on the left! ✨
                                        </p>
                                    </div>
                                ) : (
                                    <div className="space-y-4 max-h-[620px] overflow-y-auto pr-2">
                                        {posts.map((p, idx) => (
                                            <div
                                                key={p.id || idx}
                                                className="p-5 bg-white/80 backdrop-blur-sm rounded-2xl shadow-sm border border-slate-200/70 hover:shadow-md transition-shadow"
                                            >
                                                <div className="flex items-start justify-between gap-3 mb-2">
                                                    <h4 className="font-bold text-slate-900 text-base leading-snug">
                                                        {p.title}
                                                    </h4>
                                                    <span className="text-[11px] font-bold text-slate-500 bg-slate-100 px-2 py-0.5 rounded-md shrink-0">
                                                        @{p.author || p.username || "author"}
                                                    </span>
                                                </div>
                                                <p className="text-slate-700 text-sm whitespace-pre-wrap leading-relaxed">
                                                    {p.content}
                                                </p>
                                            </div>
                                        ))}
                                    </div>
                                )}
                            </div>
                        </div>
                    ) : (
                        <div className="flex items-center justify-center">
                            <AuthForm onLogin={handleLogin} onNotify={notify} />
                        </div>
                    )}
                </div>
            </div>
        </div>
    )
}

export default App