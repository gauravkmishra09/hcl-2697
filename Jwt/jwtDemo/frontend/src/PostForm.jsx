import React, { useActionState } from "react";
import { api } from "./Api";
import SubmitButton from "./SubmitButton";

const PostForm = ({ onCreated, onNotify }) => {
    const submitAction = async (prev, formData) => {
        const title = formData.get("title")?.trim();
        const content = formData.get("content")?.trim();

        if (!title || !content) {
            onNotify?.({
                type: "error",
                message: "Title and content are required!",
            });
            return {
                error: "Title and content is required",
                msg: "",
                title: title || "",
                content: content || "",
            };
        }

        try {
            const newPost = await api.post("/posts", { title, content });
            onNotify?.({
                type: "success",
                message: "Post created successfully! ✨",
            });
            if (onCreated) {
                await onCreated(newPost);
            }
            return { error: "", msg: "Post created", title: "", content: "" };
        } catch (error) {
            onNotify?.({
                type: "error",
                message: error.message || "Failed to create post. Token may be expired.",
            });
            return {
                error: error.message || "Failed to create post",
                msg: "",
                title,
                content,
            };
        }
    };

    const [state, formAction] = useActionState(submitAction, {
        error: "",
        msg: "",
        title: "",
        content: "",
    });

    return (
        <div className="relative z-10 w-full max-w-lg">
            {/* Header */}
            <div className="mb-6">
                <h2 className="text-3xl font-extrabold text-slate-900 tracking-tight font-heading">
                    Create New Post
                </h2>
                <p className="text-slate-600 text-sm mt-1">
                    Share your thoughts with the community.
                </p>
            </div>

            {/* Direct Form without card container */}
            <form action={formAction} className="space-y-5">
                <div>
                    <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-1.5">
                        Post Title
                    </label>
                    <input
                        type="text"
                        name="title"
                        defaultValue={state.title}
                        required
                        placeholder="e.g. Journey through Vrindavan"
                        className="w-full px-4 py-3 bg-white/90 border border-slate-300 rounded-xl text-slate-900 placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-slate-900 focus:border-slate-900 shadow-sm transition-all"
                    />
                </div>

                <div>
                    <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-1.5">
                        Content
                    </label>
                    <textarea
                        name="content"
                        defaultValue={state.content}
                        required
                        rows={4}
                        placeholder="Write your story, learnings or updates here..."
                        className="w-full px-4 py-3 bg-white/90 border border-slate-300 rounded-xl text-slate-900 placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-slate-900 focus:border-slate-900 shadow-sm transition-all resize-none"
                    />
                </div>

                <div className="pt-1">
                    <SubmitButton />
                </div>
            </form>
        </div>
    );
};

export default PostForm;

